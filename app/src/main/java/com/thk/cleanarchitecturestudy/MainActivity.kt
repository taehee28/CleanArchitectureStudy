package com.thk.cleanarchitecturestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.thk.cleanarchitecturestudy.databinding.ActivityMainBinding
import com.thk.cleanarchitecturestudy.databinding.ItemNumberBinding
import com.thk.cleanarchitecturestudy.viewmodel.MainViewModel
import com.thk.domain.model.NumberModel
import dagger.hilt.android.AndroidEntryPoint
import java.security.SecureRandom
import kotlin.random.Random
import kotlin.random.nextInt

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    private val listAdapter = NumberListAdapter()
    private val random = Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvList.adapter = listAdapter

            btnAdd.setOnClickListener {
                val num = generateRandomNumber()
                viewModel.insertNumber(num)
            }

            btnClear.setOnClickListener { viewModel.clearNumbers() }
        }

        // viewModel이 가지는 LiveData를 관찰(observe)
        viewModel.numbers.observe(this) { list ->
            listAdapter.submitList(list)
        }
    }

    /**
     * 랜덤한 숫자를 생성하는 함수
     */
    private fun generateRandomNumber() = random.nextInt(0..Int.MAX_VALUE)
}

/**
 * RecyclerView에 설정해줄 Adatper의 구현 클래스
 */
class NumberListAdapter : ListAdapter<NumberModel, NumberListAdapter.NumberViewHolder>(NumberDiffUtil()) {

    inner class NumberViewHolder(private val binding: ItemNumberBinding) : ViewHolder(binding.root) {
        internal fun binding(item: NumberModel) {
            binding.tvNumber.text = item.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    override fun getItemId(position: Int): Long = getItem(position).id.toLong()
}

/**
 * [ListAdapter]가 받는 새로운 데이터 리스트를 기존의 데이터 리스트와 비교하는 DiffUtil
 */
class NumberDiffUtil : DiffUtil.ItemCallback<NumberModel>() {
    override fun areItemsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
        return oldItem.value == newItem.value
    }
}