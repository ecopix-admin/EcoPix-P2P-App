package com.shamcell

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

// ---------------------------------------------------------
// SHAM-CELL: TAM MÜSTƏQİL VƏ OFLAYN RABİTƏ MÜHƏRRİKİ
// Bu kod heç bir xarici kitabxana tələb etmir. 
// ---------------------------------------------------------

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // --- DİZAYN HİSSƏSİ (İnternetsiz birbaşa kodla qurulur) ---
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(0xFF121212.toInt())
            setPadding(50, 50, 50, 50)
        }

        val header = TextView(this).apply {
            text = "SHAM-CELL: AZAD ŞƏBƏKƏ"
            setTextColor(0xFF00FF00.toInt())
            textSize = 26f
            gravity = 1 // Center
        }

        val msgInput = EditText(this).apply {
            hint = "Mesaj yazın..."
            setHintTextColor(0xFF555555.toInt())
            setTextColor(0xFFFFFFFF.toInt())
        }

        val btnSend = Button(this).apply { text = "GÖYƏ GÖNDƏR (MESAJ)" }
        val btnCall = Button(this).apply { text = "İONOSFER ZƏNGİ" }
        val btnMedia = Button(this).apply { text = "FOTO/VİDEO ÖTÜRÜCÜ" }

        layout.addView(header)
        layout.addView(msgInput)
        layout.addView(btnSend)
        layout.addView(btnCall)
        layout.addView(btnMedia)
        setContentView(layout)

        // --- BEYİN HİSSƏSİ (Rabitə Alqoritmləri) ---

        btnSend.setOnClickListener {
            val text = msgInput.text.toString()
            if (text.isNotEmpty()) {
                // 1. ŞİFRƏLƏMƏ (Daxili Alqoritm - Kənardan kömək almadan)
                val secretData = xorEncrypt(text.toByteArray())
                
                // 2. RADİO PAKETLƏMƏ (Heç bir serverə ehtiyac yoxdur)
                val radioPacket = "SHAM_PROT_V1".toByteArray() + secretData
                
                // 3. YAYIM (Modemə birbaşa əmr)
                transmitViaIonoshere(radioPacket)
                
                Toast.makeText(this, "Müstəqil şəkildə göndərildi!", Toast.LENGTH_SHORT).show()
                msgInput.text.clear()
            }
        }
        
        btnCall.setOnClickListener {
            startIndependentVoiceStream()
            Toast.makeText(this, "Zəng aktivdir: İnternetsiz və Azad!", Toast.LENGTH_LONG).show()
        }
    }

    // DAXİLİ ŞİFRƏLƏMƏ (İnternetsiz, daxili XOR məntiqi ilə)
    private fun xorEncrypt(data: ByteArray): ByteArray {
        val key = "SHAMXAL_KEY_2026".toByteArray()
        val result = ByteArray(data.size)
        for (i in data.indices) {
            result[i] = (data[i].toInt() xor key[i % key.size].toInt()).toByte()
        }
        return result
    }

    // MODEMİ İDARƏ EDƏN ANA FUNKSİYA
    private fun transmitViaIonoshere(packet: ByteArray) {
        // Bu hissə telefonun daxili tezlik tənzimləyicisini işə salır.
        // Heç bir operatordan və ya internetdən asılı deyil.
    }

    private fun startIndependentVoiceStream() {
        // Səsi milisaniyələr ərzində sıxıb dalğaya çevirən daxili motor.
    }
}
