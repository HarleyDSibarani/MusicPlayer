package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Deklarasi Variable
    private Button Play, Pause, Stop;
    private Button Play2, Pause2, Stop2;
    private Button Play3, Pause3, Stop3;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Button
        Play = findViewById(R.id.play);
        Pause = findViewById(R.id.pause);
        Stop = findViewById(R.id.stop);

        Play2 = findViewById(R.id.play2);
        Pause2 = findViewById(R.id.pause2);
        Stop2 = findViewById(R.id.stop2);

        Play3 = findViewById(R.id.play3);
        Pause3 = findViewById(R.id.pause3);
        Stop3 = findViewById(R.id.stop3);

        //Menambahkan Listener pada Button
        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);

        Play2.setOnClickListener(this);
        Pause2.setOnClickListener(this);
        Stop2.setOnClickListener(this);

        Play3.setOnClickListener(this);
        Pause3.setOnClickListener(this);
        Stop3.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal() {
        Play.setEnabled(true);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(true);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play3.setEnabled(true);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

    }

    //Method untuk memainkan musik
    private void playAudio() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.hikari);
        Play.setEnabled(false);
        Pause.setEnabled(true);
        Stop.setEnabled(true);

        Play3.setEnabled(false);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        Play2.setEnabled(false);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);


        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    private void playAudio2() {
        mediaPlayer2 = MediaPlayer.create(MainActivity.this, R.raw.wecan);
        Play2.setEnabled(false);
        Pause2.setEnabled(true);
        Stop2.setEnabled(true);

        Play.setEnabled(false);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play3.setEnabled(false);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        try {
            mediaPlayer2.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer2.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    private void playAudio3() {
        mediaPlayer3 = MediaPlayer.create(MainActivity.this, R.raw.run);
        Play3.setEnabled(false);
        Pause3.setEnabled(true);
        Stop3.setEnabled(true);

        Play.setEnabled(false);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(false);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        try {
            mediaPlayer3.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer3.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk mengentikan musik
    private void pauseAudio() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer.isPlaying()) {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                Pause.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Pause.setText("Pause");
            }
        }
    }

    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer2.isPlaying()) {
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
                Pause2.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                Pause2.setText("Pause");
            }
        }
    }

    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer3.isPlaying()) {
            if (mediaPlayer3 != null) {
                mediaPlayer3.pause();
                Pause3.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer3 != null) {
                mediaPlayer3.start();
                Pause3.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio() {
        mediaPlayer.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    private void stopAudio2() {
        mediaPlayer2.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer2.prepare();
            mediaPlayer2.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    private void stopAudio3() {
        mediaPlayer3.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer3.prepare();
            mediaPlayer3.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                playAudio();
                break;

            case R.id.pause:
                pauseAudio();
                break;

            case R.id.stop:
                stopAudio();
                break;

            case R.id.play2:
                playAudio2();
                break;

            case R.id.pause2:
                pauseAudio2();
                break;

            case R.id.stop2:
                stopAudio2();
                break;

            case R.id.play3:
                playAudio3();
                break;

            case R.id.pause3:
                pauseAudio3();
                break;

            case R.id.stop3:
                stopAudio3();
                break;
        }
    }
}