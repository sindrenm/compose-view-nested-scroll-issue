package dev.sindrenm.showcase.compose.viewcompat.nestedscroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.sindrenm.showcase.compose.viewcompat.nestedscroll.databinding.FragmentMainViewBinding
import dev.sindrenm.showcase.compose.viewcompat.nestedscroll.databinding.ListItemBinding

class MainViewFragment : Fragment() {
  lateinit var viewBinding: FragmentMainViewBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    viewBinding = FragmentMainViewBinding.inflate(inflater, container, false)

    return viewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(view.findViewById<RecyclerView>(R.id.recycler_view)) {
      adapter = ListItemAdapter()
      layoutManager = LinearLayoutManager(context)
    }
  }
}

class ListItemAdapter : ListAdapter<Int, ListItemViewHolder>(ItemDiffCallback) {
  init {
    submitList(numbers.toList())
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewBinding = ListItemBinding.inflate(inflater, parent, false)

    return ListItemViewHolder(viewBinding)
  }

  override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}

object ItemDiffCallback : DiffUtil.ItemCallback<Int>() {
  override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
    return oldItem == newItem
  }
}

class ListItemViewHolder(
  private val viewBinding: ListItemBinding,
) : RecyclerView.ViewHolder(viewBinding.root) {
  fun bind(number: Int) {
    viewBinding.textView.text = viewBinding.root.resources.getString(R.string.list_item_label, number)
  }
}
