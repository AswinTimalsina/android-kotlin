package android.example.myapplication

import android.content.Context
import android.example.myapplication.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myName: MyName = MyName("TimalsinaG")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName   //binding the myName from xml file with myName of this mainActivity file


//        findViewById<Button>(R.id.nickname_button).setOnClickListener{
//            addNickNameOnScreen(it)
//        }

        binding.nicknameButton.setOnClickListener{
            addNickNameOnScreen(it)
        }

    }



    private fun addNickNameOnScreen(view : View){
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val textView = findViewById<TextView>(R.id.nickname_text)

//        textView.text = editText.text;
//        editText.visibility = View.GONE
//        view.visibility = View.GONE  //button
//        textView.visibility = View.VISIBLE
        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
            myName?.nickName = nicknameEdit.text.toString()   //string required
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

