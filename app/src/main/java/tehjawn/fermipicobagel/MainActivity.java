package tehjawn.fermipicobagel;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Activity;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        final Button rngButton = (Button) findViewById(R.id.rngButton);
        final Bagels bagel1 = new Bagels();
        rngButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView rngIndicatorTV = (TextView) findViewById(R.id.rngIndicator);
                rngIndicatorTV.setText("Random number has been generated!\n"
                +"The last random number was ( "+bagel1.getSecretNumber()+" )");
                bagel1.createSecretNumber();
                bagel1.resetCount();
            }

        });

        final Button checkButton = (Button) findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView userGuessTV = (TextView) findViewById(R.id.userGuess);
                TextView hintTV = (TextView) findViewById(R.id.hint);

                String userGuess = userGuessTV.getText().toString();
                if (userGuess.equals(null)) {
                    Toast.makeText(getApplicationContext(), "Error! Enter a guess first!",
                            Toast.LENGTH_LONG).show();
                } else if (userGuess.length()!=3){
                    Toast.makeText(getApplicationContext(), "Error! Your guess must be three digits!",
                            Toast.LENGTH_LONG).show();
                } else {
                    bagel1.playGame(userGuess);

                    if (bagel1.win) {
                        hintTV.setText("You Win!\nIt took you " + bagel1.getCount() + bagel1.getTries());
                    } else {
                        hintTV.setText(bagel1.getHint());
                        bagel1.hintReset();
                    }
                }
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
