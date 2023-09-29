package com.example.capstonedesign.board

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.capstonedesign.R
import com.example.capstonedesign.databinding.ActivityBoardWriteBinding
import com.example.capstonedesign.utils.FBAuth
import com.example.capstonedesign.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener {

            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()

            // uid를 가져온다.
            val uid = FBAuth.getUid()

            // time을 가져온다.
            val time = FBAuth.getTime()

            FBRef.boardRef
                .push() // 랜덤한 값
                .setValue(BoardModel(title,content,uid,time))

            Toast.makeText(this,"게시글 입력 완료", Toast.LENGTH_LONG).show()

            finish()
        }
    }
}