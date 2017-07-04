package com.home.example.notepatt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.home.example.notepatt.commons.DBHelper;

import java.util.ArrayList;

/**
 * Created by HPINTEL on 01/07/2017.
 */

public class QuickCopyMain extends Activity{


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Ingrese su pedido");

        refresh();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        refresh();
    }

    // setup options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                addEntry();
                break;
            case R.id.menuHelp:
                showHelp();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showHelp() {
        TextView tv = new TextView(this);
        tv
                .setText("1. Utilice el botón de menú para añadir nuevos pedidos\n"
                        + "\n\n2. Toque un producto existente para copiar esa entrada al lugar donde desee\n"
                        + "\n\n3. Pulsar prolongadamente al producto ingresado  para editar o eliminar el pedido\n");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Instrucciones").setView(tv).setCancelable(true)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void addEntry() {

        final EditText edit = new EditText(this);
        edit.setEms(20);
        edit.setLines(5);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Añadir un nuevo pedido").setView(edit).setCancelable(true)
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String value = edit.getText().toString();
                                if (!value.equals("")) {
                                    DBHelper.get(QuickCopyMain.this).addEntry(
                                            value);
                                    refresh();
                                }
                            }
                        }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void editEntry(final String oldValue) {

        final EditText edit = new EditText(this);
        edit.setText(oldValue);
        edit.setEms(20);
        edit.setLines(5);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Editar pedido").setView(edit).setCancelable(true)
                .setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String value = edit.getText().toString();
                                if (!value.equals("")) {
                                    DBHelper.get(QuickCopyMain.this).updateEntry(oldValue, value);
                                    refresh();
                                }
                            }
                        }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).setNeutralButton("Delete", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String value = edit.getText().toString();
                if (!value.equals("")) {
                    DBHelper.get(QuickCopyMain.this).deleteEntry(oldValue);
                    refresh();
                }
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    protected void refresh() {
        setContentView(R.layout.activity_main);
        DBHelper db = DBHelper.get(this);

        ArrayList<String> entries = db.getEntries();
        if (entries.size() == 0) {
            TextView tv = (TextView)findViewById(R.id.textEntries);
            tv.setText("Tu lista de pedidos aún está vacía\n\n\nUtilice el botón de menú de su dispositivo para agregar nuevos productos a su lista de pedidos \n"
                    +  "\n\nLos elementos se ordenarán alfabéticamente\n");
        } else {
            TextView tv = (TextView)findViewById(R.id.textEntries);
            tv.setText("Toca para copiar\n / Pulsar prolongadamente para editar\n");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    R.layout.simple_list_item_1, entries);
            ListView lv = (ListView) findViewById(R.id.valuesList);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int arg2, long arg3) {
                    String value = (String) arg0.getAdapter().getItem(arg2);
                    ClipboardManager manager = (ClipboardManager) QuickCopyMain.this
                            .getSystemService(CLIPBOARD_SERVICE);
                    manager.setText(value);
                    Toast t = Toast.makeText(QuickCopyMain.this, "Copiado \"" + value
                            + "\"" + " Al portapapeles\n", 6000);
                    t.show();
                    finish();
                }

            });

            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                    editEntry((String) arg0.getAdapter()
                            .getItem(arg2));
                    return false;
                }

            });
        }
    }

}
