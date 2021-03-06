package example.codeclan.com.olderyoungercardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 20/01/2017.
 */

public class MainActivity extends AppCompatActivity{

    TextView gameRules;
    ImageView playingCardImage;
    Button higherButton;
    Button lowerButton;
    Intent intent;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        gameRules = (TextView) findViewById(R.id.main_text_view);
        playingCardImage = (ImageView) findViewById(R.id.main_img);
        higherButton = (Button) findViewById(R.id.higher_button);
        lowerButton = (Button) findViewById(R.id.lower_button);
        game = new Game();

        cardDetermination();

        Log.d(getClass().toString(), "onCreate made");
    }

    public void onHigherButtonPressed(View button){
        Log.d(getClass().toString(), "Higher button pressed");

        intent = new Intent(MainActivity.this, Pop.class);

        String result = game.higherGuess();

        intent.putExtra("result", result);
        startActivity(intent);
    }

    public void onLowerButtonPressed(View button){
        Log.d(getClass().toString(), "Higher button pressed");

        intent = new Intent(MainActivity.this, Pop.class);

        String result = game.lowerGuess();

        intent.putExtra("result", result);
        startActivity(intent);
    }


    public void cardDetermination(){
        if (game.theComputerCard().contains("Stonehenge")){
            playingCardImage.setImageResource(R.drawable.stonehenge_playing);
        }
        else if (game.theComputerCard().contains("Taj")){
            playingCardImage.setImageResource(R.drawable.taj_mahal_playing);
        }
        else if (game.theComputerCard().contains("seum")){
            playingCardImage.setImageResource(R.drawable.colosseum_playing);
        }
        else if (game.theComputerCard().contains("Eiffel")){
            playingCardImage.setImageResource(R.drawable.eiffel_playing);
        }
        else if (game.theComputerCard().contains("Hagia")){
            playingCardImage.setImageResource(R.drawable.hagia_sophia_playing);
        }
        else if (game.theComputerCard().contains("Pyramids")){
            playingCardImage.setImageResource(R.drawable.pyramids_playing);
        }
        else if (game.theComputerCard().contains("Petra")){
            playingCardImage.setImageResource(R.drawable.petra_playing);
        }
        else if (game.theComputerCard().contains("Moai")){
            playingCardImage.setImageResource(R.drawable.moai_playing);
        }
        else if (game.theComputerCard().contains("Machu")){
            playingCardImage.setImageResource(R.drawable.machu_picchu_playing);
        }
        else if (game.theComputerCard().contains("Angkor")){
            playingCardImage.setImageResource(R.drawable.angkor_wat_playing);
        }
        else if (game.theComputerCard().contains("Dun")){
            playingCardImage.setImageResource((R.drawable.broch_playing));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_more_info){
            Log.d(getClass().toString(), "More Info selected");

            intent = new Intent(MainActivity.this, MonumentInfoActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.home){
            Log.d(getClass().toString(), "Home Button selected");

            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
