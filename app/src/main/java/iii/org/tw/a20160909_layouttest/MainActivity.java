package iii.org.tw.a20160909_layouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnGuess;
    private TextView showText;
    private EditText input;
    private String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = createAnswer(3);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        showText = (TextView) findViewById(R.id.showText);
        input = (EditText) findViewById(R.id.input);

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGuess();
            }
        });


    }

    private void  doGuess() {
        String strInput = input.getText().toString();
        String result = checkAB(answer,strInput);
        showText.append( strInput + ":" + result);
        input.setText("");
    }



    static String createAnswer(int n) {
        int [] porkCard = new int[n];
        for (int i=0 ; i<porkCard.length ; i++) {
            int temp;
            //------檢查是否重複----------
            //------使用do-while來判斷----
            boolean isRepeat;
            do {
                isRepeat = false;
                temp =(int)(Math.random()*10);
                for (int j=0 ; j<i ; j++) {
                    if (temp == porkCard[j]) {
                        isRepeat = true;
                        break;
                    }
                }
            } while (isRepeat);
            porkCard[i] = temp;
        }
        String ret = "";
        //-----使用foreach將陣列中的值放入ret中
        for (int p : porkCard) {
            ret += p;
        }
        return ret;
    }
    static String checkAB(String b, String a) {
        int A , B ;
        A = B = 0;
        for (int i=0 ; i<a.length() ; i++) {
            if (b.charAt(i) == a.charAt(i)) {
                A++;
            } else if (a.indexOf(b.charAt(i)) != -1) {
                B++;
            } else {

            }
        }
        return A + "A" + B + "B";
    }
}
