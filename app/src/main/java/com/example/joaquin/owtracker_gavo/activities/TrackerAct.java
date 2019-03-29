package com.example.joaquin.owtracker_gavo.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joaquin.owtracker_gavo.R;
import com.example.joaquin.owtracker_gavo.api.model.Player;
import com.example.joaquin.owtracker_gavo.api.service.API;
import com.example.joaquin.owtracker_gavo.api.service.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackerAct extends AppCompatActivity {

    TextView txtProfileName,txtGamesWon,txtPlatform,txtLevel,txtRating,txtRatingName,txtCargando;
    ImageView imageProfileImage,imageLevelIcon,imagePrestige,imageRatingIcon;
    Button btnCasualStats,btnMatchmakingStats;
    String btname,btnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        //Traigo el bundle del otro activity
        Bundle btdata = this.getIntent().getExtras();
        btname = btdata.getString("btname");
        btnumber = btdata.getString("btnumber");
        //Traigo el bundle del otro activity
        llamada();
        setFonts();
        bindUI();

    }

    public void bindUI(){
        txtProfileName = findViewById(R.id.textViewProfileName);
        txtGamesWon = findViewById(R.id.textViewGamesWon);
        txtPlatform = findViewById(R.id.textViewPlatform);
        txtLevel = findViewById(R.id.textViewLevel);
        txtRating = findViewById(R.id.textViewRating);
        txtRatingName = findViewById(R.id.textViewRatingName);
        imageProfileImage = findViewById(R.id.imageViewProfileImage);
        imageLevelIcon = findViewById(R.id.imageViewLevelIcon);
        imagePrestige = findViewById(R.id.imageViewPrestigeIcon);
        imageRatingIcon = findViewById(R.id.imageViewRatingIcon);
        btnCasualStats = findViewById(R.id.buttonCasualStats);
        btnMatchmakingStats = findViewById(R.id.buttonMMStats);
    }

    public void setFonts(){
        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ow_font_title.ttf");
        txtCargando.setTypeface(font);
        txtProfileName.setTypeface(font);
        txtGamesWon.setTypeface(font);
        txtPlatform.setTypeface(font);
        txtLevel.setTypeface(font);
        txtRating.setTypeface(font);
        txtRatingName.setTypeface(font);
        btnCasualStats.setTypeface(font);
        btnMatchmakingStats.setTypeface(font);
    }

    public void llamada(){

        Service service = API.getAPI().create(Service.class);
        Call<Player> playerCall = service.getPlayer(btname+"-"+btnumber);
        playerCall.enqueue(new Callback<Player>() {

            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                try{
                    Player player = response.body();

                    String username = player.getUsername();
                    txtProfileName.setText(""+username);
                    int level = player.getLevel();
                    txtLevel.setText(""+level);
                    String ratingname = player.getRatingname();
                    txtRatingName.setText(""+ratingname);
                    int rating = player.getRating();
                    txtRating.setText(""+rating);
                    int gameswon = player.getGameswon();
                    txtGamesWon.setText(""+gameswon);

/*                   String icon = player.getIcon();
                     Picasso.with(MainActivity.this)
                            .load(icon+"png")
                            //.resize(200,150)
                            .fit()
                            .into(imageProfileImage);

                    String levelicon = player.getLevelicon();
                    Picasso.with(MainActivity.this)
                            .load(levelicon+"png")
                            .fit()
                            .into(imageLevelIcon);

                    String prestigeicon = player.getPrestigeicon();
                    Picasso.with(MainActivity.this)
                            .load(prestigeicon+"png")
                            .fit()
                            .into(imagePrestige);

                    String ratingicon = player.getRatingicon();
                    Picasso.with(MainActivity.this)
                            .load(ratingicon+"png")
                            .fit()
                            .into(imageRatingIcon);
*/

                }catch(Exception e){

                    txtProfileName.setText("Ese perfil no existe o bien no tiene rango competitivo");

                }

            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                llamada();
            }
        });
    }


}
