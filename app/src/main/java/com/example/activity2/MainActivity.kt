package com.example.activity2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
                /*
                 * =========================
                 * INPUT: Binary EditTexts
                 * Each EditText accepts only 0 or 1
                 * Each represents a specific binary weight
                 * =========================
                 */
                val bin128 = findViewById<EditText>(R.id.edit_binary128)
                val bin64  = findViewById<EditText>(R.id.edit_binary64)
                val bin32  = findViewById<EditText>(R.id.edit_binary32)
                val bin16  = findViewById<EditText>(R.id.edit_binary16)
                val bin8   = findViewById<EditText>(R.id.edit_binary8)
                val bin4   = findViewById<EditText>(R.id.edit_binary4)
                val bin2   = findViewById<EditText>(R.id.edit_binary2)
                val bin1   = findViewById<EditText>(R.id.edit_binary1)

                /*
                 * =========================
                 * OUTPUT: Per-bit Decimal TextViews
                 * Shows the decimal equivalent of each bit
                 * If input = 1 → show its weight
                 * If input = 0 → show 0
                 * =========================
                 */
                val dec128 = findViewById<TextView>(R.id.txt_decimal128)
                val dec64  = findViewById<TextView>(R.id.txt_decimal64)
                val dec32  = findViewById<TextView>(R.id.txt_decimal32)
                val dec16  = findViewById<TextView>(R.id.txt_decimal16)
                val dec8   = findViewById<TextView>(R.id.txt_decimal8)
                val dec4   = findViewById<TextView>(R.id.txt_decimal4)
                val dec2   = findViewById<TextView>(R.id.txt_decimal2)
                val dec1   = findViewById<TextView>(R.id.txt_decimal1)

                /*
                 * =========================
                 * OUTPUT: Bit Overview
                 * Shows the final 8-bit binary number
                 * Displayed when the button is clicked
                 * =========================
                 */
                val bitViews = listOf(
                    findViewById<TextView>(R.id.txt_bit8), // 128 (MSB)
                    findViewById<TextView>(R.id.txt_bit7), // 64
                    findViewById<TextView>(R.id.txt_bit6), // 32
                    findViewById<TextView>(R.id.txt_bit5), // 16
                    findViewById<TextView>(R.id.txt_bit4), // 8
                    findViewById<TextView>(R.id.txt_bit3), // 4
                    findViewById<TextView>(R.id.txt_bit2), // 2
                    findViewById<TextView>(R.id.txt_bit1)  // 1 (LSB)
                )

                 // Final decimal result
                val txtDecimalResult = findViewById<TextView>(R.id.txt_decimalResult)
                val btnFind = findViewById<Button>(R.id.btn_find)

                /*
                 * =====================================================
                 * FUNCTION: setupBinaryWatcher
                 *
                 * Purpose:
                 * - Listens to changes in an EditText
                 * - Validates input (only 0 or 1 allowed)
                 * - Updates the corresponding decimal TextView
                 *
                 * Why use doAfterTextChanged?
                 * - Required by the activity
                 * - Automatically reacts when user types
                 * =====================================================
                 */
                fun setupBinaryWatcher(
                    editText: EditText,
                    decimalView: TextView,
                    weight: Int
                ) {
                    editText.doAfterTextChanged { text ->
                        if (text.toString() == "1") {
                            decimalView.text = weight.toString()
                        } else {
                            // Treat everything else as 0 (including empty input)
                            decimalView.text = "0"
                        }
                    }
                }


                /*
                * =========================
                * Attach watchers to inputs
                * =========================
                */
                setupBinaryWatcher(bin128, dec128, 128)
                setupBinaryWatcher(bin64,  dec64,  64)
                setupBinaryWatcher(bin32,  dec32,  32)
                setupBinaryWatcher(bin16,  dec16,  16)
                setupBinaryWatcher(bin8,   dec8,   8)
                setupBinaryWatcher(bin4,   dec4,   4)
                setupBinaryWatcher(bin2,   dec2,   2)
                setupBinaryWatcher(bin1,   dec1,   1)

                /*
                 * =====================================================
                 * BUTTON CLICK:
                 * - Reads all binary inputs
                 * - Displays the full 8-bit binary number
                 * - Computes and displays the final decimal value
                 * =====================================================
                 */
                btnFind.setOnClickListener {

                    val binaries = listOf(
                        bin128.text.toString(),
                        bin64.text.toString(),
                        bin32.text.toString(),
                        bin16.text.toString(),
                        bin8.text.toString(),
                        bin4.text.toString(),
                        bin2.text.toString(),
                        bin1.text.toString()
                    )

                    val weights = listOf(128, 64, 32, 16, 8, 4, 2, 1)

                    var total = 0

                    // Loop through all bits
                    for (i in binaries.indices) {
                        val bit = if (binaries[i] == "1") 1 else 0

                        // Show binary overview
                        bitViews[i].text = bit.toString()

                        // Add to total decimal value
                        total += bit * weights[i]
                    }

                    // Display final decimal result
                    txtDecimalResult.text = total.toString()
                }

        val btnClear = findViewById<Button>(R.id.btn_clear)

        btnClear.setOnClickListener {
            // Reset all binary inputs to "0"
            bin128.setText("0")
            bin64.setText("0")
            bin32.setText("0")
            bin16.setText("0")
            bin8.setText("0")
            bin4.setText("0")
            bin2.setText("0")
            bin1.setText("0")

            // Reset per-bit decimal TextViews
            dec128.text = "0"
            dec64.text  = "0"
            dec32.text = "0"
            dec16.text = "0"
            dec8.text  = "0"
            dec4.text  = "0"
            dec2.text  = "0"
            dec1.text  = "0"

            // Reset bit overview to 0
            for (bitView in bitViews) {
                bitView.text = "0"
            }

            // Reset final decimal result
            txtDecimalResult.text = "0"
        }
    }
}