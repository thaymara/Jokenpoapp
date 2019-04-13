package br.com.tmara.jokenpoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val ROCK = 0
    val PAPER = 1
    val SCISSORS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivRock.setOnClickListener {
            realizarJogada(ROCK)
        }

        ivPaper.setOnClickListener {
            realizarJogada(PAPER)
        }

        ivScissors.setOnClickListener {
            realizarJogada(SCISSORS)
        }
    }

    private fun mudaImagem(ivPlayer: ImageView, jogada: Int) {
        when (jogada) {
            ROCK -> {
                setImagem(R.drawable.pedra, ivPlayer)
            }
            SCISSORS -> {
                setImagem(R.drawable.tesoura, ivPlayer)
            }
            PAPER -> {
                setImagem(R.drawable.papel, ivPlayer)
            }
        }
    }

    private fun setImagem(icone: Int, ivPlayer:ImageView) {
        ivPlayer.setImageDrawable(
            ContextCompat.getDrawable(
                this, icone
            )
        )
    }

    fun realizarJogada(jogadaPlayer: Int) {

        val jogadaAndroid = Random().nextInt(3)


        mudaImagem(ivYou, jogadaPlayer)
        mudaImagem(ivAndroid, jogadaAndroid)

        when (jogadaPlayer) {
            ROCK -> {
                when (jogadaAndroid) {
                    ROCK -> {
                        empatou()
                    }
                    PAPER -> {
                        perdeu()
                    }
                    SCISSORS -> {
                        ganhou()
                    }
                }
            }

            PAPER -> {
                when (jogadaAndroid) {
                    ROCK -> {
                        ganhou()
                    }
                    PAPER -> {
                        empatou()
                    }
                    SCISSORS -> {
                        perdeu()
                    }
                }
            }

            SCISSORS -> {
                when (jogadaAndroid) {
                    ROCK -> {
                        perdeu()
                    }
                    PAPER -> {
                        ganhou()
                    }
                    SCISSORS -> {
                        empatou()
                    }
                }
            }
        }
    }

    private fun perdeu() {
        tvResult.text = "Perdeu"
    }

    private fun empatou() {
        tvResult.text = "Empatou"
    }

    private fun ganhou() {
        tvResult.text = "Ganhou"
    }
}
