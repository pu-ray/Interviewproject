package com.gamecodeschool.interviewproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_editcountry.*

import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar);

        floatingActionButton.setOnClickListener(e -> {
            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra(Constants.PERSON_INTENT_EDIT, false);
            ActivityCompat.startActivityForResult(intent, REQUEST_CODE_EDIT);
        });

        buttonCancel.setOnClickListener(e -> {
            setResult(RESULT_CANCELED);
            finish();
        });
        buttonEdit.setOnClickListener { e ->
            val firstName = editTextName.getText().toString().trim()
            country.setName(Attributes.Name)
            val intent = Intent()
            val bundle = Bundle()
            bundle.putParcelable(Constants.country_INTENT_OBJECT, country)
            bundle.putBoolean(Constants.country_INTENT_EDIT, isEdit)
            bundle.putInt(Constants.country_INTENT_INDEX, index)
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        public class MainActivity extends AppCompatActivity implements OnEditListener{
            ...
            @Override
            public void editItem(country country, int index) {
                Intent intent = new Intent(this, Editcountry.class);
                intent.putExtra(Constants.country_INTENT_EDIT, true);
                intent.putExtra(Constants.country_INTENT_INDEX, index);
                intent.putExtra(Constants.country_INTENT_OBJECT, country);
                startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
