package com.gamecodeschool.interviewproject

import android.os.Bundle
import android.app.Activity
import android.widget.Button

import kotlinx.android.synthetic.main.activity_editcountry.*
import android.widget.EditText
import android.R
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable.Creator
import android.os.Parcelable
import android.support.annotation.NonNull

private var editTextFirstName: EditText? = null
private val buttonEdit: Button? = null
private val buttonCancel: Button? =
    private
val country: country? = null
private var index = -1
private var isEdit = false
fun setupViews(): ???
fun initPerson(): ???
private country country;
private int index = -1;
private boolean isEdit = false

class Editcountry : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editcountry)

    }

    private fun setupViews() {
        editTextName = findViewById(R.id.editTextName)
        buttonEdit = findViewById(R.id.buttonEdit)
        buttonCancel = findViewById(R.id.buttonCancel)
    }

    private fun Stringcountry() {
        val intent = intent
        if (intent != null) {
            isEdit = intent.getBooleanExtra(Constants.country_INTENT_EDIT, false)
            if (isEdit) {
                country = intent.getParcelableExtra(Constants.country_INTENT_OBJECT)
                index = intent.getIntExtra(Constants.country_INTENT_INDEX, -1)
                if (index === -1) {
                    setResult(Activity.RESULT_CANCELED)
                    finish()
                }
                editTextFirstName.setText(person.getFirstName())
                buttonEdit.text = getString(R.string.button_edit)
            } else {
                country = country()
                buttonEdit.text = getString(R.string.button_add)
            }
        }
    }

    inner class Person//constructor setters and getters
    protected constructor(`in`: Parcel) : Parcelable {
        init {
            Name = `in`.readString()


            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(Name)

            }

            companion object {

                val CREATOR: Creator<Person> = object : Creator<Person> {
                    override fun createFromParcel(`in`: Parcel): Person {
                        return Person(`in`)
                    }

                    override fun newArray(size: Int): Array<Person> {
                        return arrayOfNulls(size)
                    }
                }
            }
        }

        interface OnEditListener {
            fun editItem(person: Person, index: Int)

        }
    }
    private OnEditListener editListener;
    public PersonAdapter(List<Person> listPerson, OnEditListener editListener)
    {
        this.listcountry = listcountry;
        this.editlistener = editListener;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position)
    {
        ...
        personViewHolder.getView().setOnClickListener(e -> {
        editListener.editItem(listPerson.get(position), position);
    });
    }

    protected fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //1: check if request code matches
        if (requestCode == REQUEST_CODE_EDIT) {
            //2:check result is OK
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    return
                }
                //3: get type of operation
                val isEdit = data.getBooleanExtra(Constants.country_INTENT_EDIT, false)
                //4: get person instance
                val person = data.getParcelableExtra(Constants.country_INTENT_OBJECT)
                if (isEdit) {
                    //get the index of the selected item
                    val index = data.getIntExtra(Constants.country_INTENT_INDEX, -1)
                    //something wrong happened, cancel operation
                    if (index == -1) {
                        return
                    }
                    //update the list
                    listcountry.set(index, country)
                    //update recyclerview
                    countryAdapter.notifyDataSetChanged()
                } else {
                    //add new object to the list
                    country.add(country)
                    //update recyclerview
                    countryAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    interface OnDeleteListener {
        fun deleteItem(country: country)
    }
    private OnEditListener editListener;
    public PersonAdapter(List<Person> listPerson, OnDeleteListener deleteListener, OnEditListener
    editListener)
    {
        this.listcountry = listcountry;
        this.deleteListener = deleteListener;
        this.editListener = editListener;
    }
}

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position)
    {
        ...
        countryViewHolder.getView().setOnLongClickListener(e -> {
        deleteListener.deleteItem(listcountry.get(position));
        return true;
    });
    }
    And we implement the
    interface in our MainActivity  as follows:

    public class MainActivity extends AppCompatActivity implements OnEditListener, OnDeleteListener
    {
    }
    @Override
    public void deleteItem(Person person)
    {
        var listcountry = null
        listcountry.remove(country);
        countryAdapter.notifyDataSetChanged();
    }
}
        }

    }