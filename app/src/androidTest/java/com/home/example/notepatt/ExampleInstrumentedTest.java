package com.home.example.notepatt;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.home.example.notepatt.bean.Productos;
import com.home.example.notepatt.bean.User;
import com.home.example.notepatt.dao.ProductosDao;
import com.home.example.notepatt.dao.UserDao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.home.example.notepatt", appContext.getPackageName());

        ProductosDao dao = new ProductosDao(appContext);
        Productos person = new Productos();
        person.setNameProductos("ccaac");
        person.setDescription("jdsjs");


        dao.saveProduct(person);

        dao.close();

    }
}
