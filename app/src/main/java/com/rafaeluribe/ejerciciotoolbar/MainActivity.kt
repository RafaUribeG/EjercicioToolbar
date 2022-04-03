package com.rafaeluribe.ejerciciotoolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    var f1:Registro = Registro()
    var f2:VerRegistros = VerRegistros()
    var f3:EliminarRegistros = EliminarRegistros()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        cargarFragmento(f1)
    }

    fun cargarFragmento(f:Fragment){
        val fm:FragmentManager = supportFragmentManager
        val ft:FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.myFrame, f)
        ft.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itRegis ->{
                cargarFragmento(f1)
            }
            R.id.itVerRegis ->{
                cargarFragmento(f2)
            }
            R.id.itEliminar ->{
                cargarFragmento(f3)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(applicationContext, "Click en botón atrás", Toast.LENGTH_SHORT).show()
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}