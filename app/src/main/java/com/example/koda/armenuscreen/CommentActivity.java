package com.example.koda.armenuscreen;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by K.Oda on 2017/09/09.
 */

public class CommentActivity extends Activity {

    private ImageButton submitBtn;
    private EditText input_editText;
    private ViewGroup commentArea;
    private ScrollView scrollView;

    //コンストラクタ
    public CommentActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_activity);

        //入力エリアを設定
        input_editText = (EditText)findViewById(R.id.edittext);
        input_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //変更されたテキストを表示
                String inputStr = editable.toString();

                if(inputStr.trim().equals("")){
                    submitBtn.setEnabled(false);
                }else{
                    submitBtn.setEnabled(true);
                }
            }
        });

        //コメント表示エリアを設定
        commentArea = (ViewGroup) findViewById(R.id.comment_scroll);

        //スクロールビューを設定
        scrollView = (ScrollView)findViewById(R.id.scrollView_comment);

        //送信ボタンを設定
        submitBtn = (ImageButton)findViewById(R.id.submit_btn);

        if(input_editText.getText().toString().trim().equals("")) submitBtn.setEnabled(false);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            public int row = 0;

            @Override
            public void onClick(View view) {
                //テキストボックスの入力をコメントに反映する
                String inputStr = input_editText.getText().toString();

                //入力をチェックする
                if(!checkInputText(inputStr)) return;

                //コメントレイアウトをViewGroupに追加
                getLayoutInflater().inflate(R.layout.comment_layout_right,commentArea);
                LinearLayout linearLayout = (LinearLayout)commentArea.getChildAt(row);

                LinearLayout commentLine = (LinearLayout)linearLayout.getChildAt(0);
                TextView textView = (TextView)commentLine.getChildAt(0);
                textView.setText(inputStr);

                //スクロールを一番下へ
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(scrollView.FOCUS_DOWN);
                    }
                });
                //送信後入力エリアを空にする
                input_editText.setText("");

                this.row++;

            }
        });

    }

    private boolean checkInputText(String str) {
        boolean result = true;
        if(str.trim().equals("")){
            result = false;
        }
        return result;
    }

}
