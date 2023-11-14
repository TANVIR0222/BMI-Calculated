package com.example.fragmrnt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmrnt.databinding.FragmentHomeBinding
import java.time.Duration
import kotlin.math.pow

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        
        binding.bottom.setOnClickListener {
            calculateBMI()
        }
        
        return binding.root
    }
    
    private fun calculateBMI() {
        
        val w = binding.width.text.toString().toFloatOrNull()
        val h = binding.height.text.toString().toFloatOrNull()
        
        if (w != null && h != null) {
            val bmi = w / (h / 100).pow(2)
            val bmiresult = String.format("%.2f", bmi)
            
            
            val bimCategory = when {
                bmi < 18.5 -> "Under Width"
                bmi < 25 -> " Normal"
                bmi < 18.5 -> "Over Width"
                
                else -> "obese"
            }
            binding.result.text = "BMI : $bmiresult\ncategory : $bimCategory"
        } else {
            binding.result.text = "Invalid Input"
        }
        
    }
    
    
}