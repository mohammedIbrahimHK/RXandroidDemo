package ibrahim.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    EditText fno,sno,result;
    Button resultButton;
    Observable<String> myObservable;
Observer<String> myObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fno=(EditText)findViewById(R.id.fno);
        sno=(EditText)findViewById(R.id.sno);
        result=(EditText)findViewById(R.id.result);
        resultButton=(Button) findViewById(R.id.get_result);
        fno.addTextChangedListener(this);
        sno.addTextChangedListener(this);
        myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                // Called when the observable has no more data to emit
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
            }

            @Override
            public void onNext(String s) {
                // Called each time the observable emits data
                Log.d("MY OBSERVER", s);
                result.setText(""+s);

            }

        };




        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("Mohammed", "onTextChanged"+s );
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("Mohammed", "onTextChanged"+s );
        int fn=0;
        int sn=0;
        int r=0;


    if(fno.getText().toString().length()!=0){
        fn=Integer.parseInt(fno.getText().toString());


    }
    if(sno.getText().toString().length()!=0){
        sn=Integer.parseInt(sno.getText().toString());


    }
    r=fn+sn;
    Log.d("Mohammed", "finasl result======"+r );
//        result.setText(""+r);
    myObservable  = Observable.just("");

  Subscription mySubscription = myObservable.subscribe(myObserver);
        myObserver.onNext(""+r);

}

    @Override
    public void afterTextChanged(Editable s) {
        Log.d("Mohammed", "onTextChanged"+s );
    }


}