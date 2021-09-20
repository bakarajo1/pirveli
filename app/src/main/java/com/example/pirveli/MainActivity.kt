package com.example.pirveli

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var verbalText: TextView
    private lateinit var numText: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        verbalText=findViewById(R.id.verbal_text)
        numText=findViewById(R.id.num_text)
        button=findViewById(R.id.button)

        button.setOnClickListener { convert() }

    }


    fun convert(){

        val ricxvi: Int = numText.getText().toString().toInt()

        var ertebi = arrayOf(
            " ",
            " erti",
            " ori",
            " sami",
            " otxi",
            " xuti",
            " eqvsi",
            " shvidi",
            " rva",
            " cxra",
            " ati",
            " tertmeti",
            " tormeti",
            " cameti",
            " totxmeti",
            " txutmeti",
            " teqvsmeti",
            " chvidmeti",
            " tvrameti",
            "cxrameti"
        )
        var sruliAtebi = arrayOf(
            " ",
            "ati ",
            " oci",
            " ocdaati",
            " ormoci",
            " ormocdaati",
            " samoci",
            " samocdaati",
            " otxmoci",
            " otxmocdaati"
        )
        var atebi = arrayOf(
            " ",
            " ",
            " ocda",
            " ocda",
            " ormocda",
            " ormocda",
            " samocda",
            " samocda",
            " otxmocda",
            " otxmocda"
        )
        var asebi = arrayOf(
            " ",
            "as ",
            " oras",
            " samas",
            " otxas",
            " xutas",
            " eqvsas",
            " shvidas",
            " rvaas",
            " cxraas"
        )
        var sruliAsebi = arrayOf(
            " ",
            "asi ",
            " orasi",
            " samasi",
            " otxasi",
            " xutasi",
            " eqvsasi",
            " shvidasi",
            " rvaasi",
            " cxraasi"
        )
        var baseString = ""


        fun ornishna(orn: Int): String {
            if (orn % 100 % 10 == 0) {
                if (orn / 10 == 1) {
                    baseString += sruliAtebi[1]
                } else if (orn / 10 == 2) {
                    baseString += sruliAtebi[2]
                } else if (orn / 10 == 3) {
                    baseString += sruliAtebi[3]
                } else if (orn / 10 == 4) {
                    baseString += sruliAtebi[4]
                } else if (orn / 10 == 5) {
                    baseString += sruliAtebi[5]
                } else if (orn / 10 == 6) {
                    baseString += sruliAtebi[6]
                } else if (orn / 10 == 7) {
                    baseString += sruliAtebi[7]
                } else if (orn / 10 == 8) {
                    baseString += sruliAtebi[8]
                } else if (orn / 10 == 9) {
                    baseString += sruliAtebi[9]
                }

                if (baseString !== "") {
                    return baseString
                }
            }


            if (orn < 20) {
                return ertebi[orn]
            } else if (orn < 100) {
                return if (orn / 10 % 2 == 0) {
                    baseString = atebi[orn / 10] + ertebi[orn % 10]
                    baseString
                } else {
                    baseString = atebi[orn / 10] + ertebi[orn % 10 + 10]
                    baseString
                }
            }
            return ""
        }


        fun minsSplit(raod: Int): String {
            val nullString = ""

            if (raod == 0) {
                return "noli"
            } else if (raod == 1000) {
                return "atasi"
            }

            if (raod % 100 == 0) {
                if (raod / 100 == 1) {
                    baseString += sruliAsebi[1]
                } else if (raod / 100 == 2) {
                    baseString += sruliAsebi[2]
                } else if (raod / 100 == 3) {
                    baseString += sruliAsebi[3]
                } else if (raod / 100 == 4) {
                    baseString += sruliAsebi[4]
                } else if (raod / 100 == 5) {
                    baseString += sruliAsebi[5]
                } else if (raod / 100 == 6) {
                    baseString += sruliAsebi[6]
                } else if (raod / 100 == 7) {
                    baseString += sruliAsebi[7]
                } else if (raod / 100 == 8) {
                    baseString += sruliAsebi[8]
                } else if (raod / 100 == 9) {
                    baseString += sruliAsebi[9]
                }

                if (baseString !== "") {
                    return baseString
                }
            }


            if (raod < 100) {
                val x = ornishna(raod)
                if (x !== nullString) {
                    return x
                }
            }

            if (raod < 1000) {
                var asi = ""


                if (raod / 100 == 1) {
                    asi += asebi[1]
                } else if (raod / 100 == 2) {
                    asi += asebi[2]
                } else if (raod / 100 == 3) {
                    asi += asebi[3]
                } else if (raod / 100 == 4) {
                    asi += asebi[4]
                } else if (raod / 100 == 5) {
                    asi += asebi[5]
                } else if (raod / 100 == 6) {
                    asi += asebi[6]
                } else if (raod / 100 == 7) {
                    asi += asebi[7]
                } else if (raod / 100 == 8) {
                    asi += asebi[8]
                } else if (raod / 100 == 9) {
                    asi += asebi[9]
                }


                val secondHalf = ornishna(raod % 100)
                return asi + secondHalf
            }
            return "1000mde chawere bicho"
        }





        verbalText.setText(minsSplit(ricxvi).toString())

    }
}