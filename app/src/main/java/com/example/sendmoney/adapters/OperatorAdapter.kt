import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.OperatorModel

class OperatorAdapter(private val dataList: ArrayList<OperatorModel>) :
    RecyclerView.Adapter<OperatorAdapter.CustomViewHolder>() {

    private var mOnClickListener: OnClickListener? = null
    private var mSelectedItem = -1


    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val image = itemview.findViewById<ImageView>(R.id.operatorImage)
        val layout = itemview.findViewById<ConstraintLayout>(R.id.backGroundColor)
        val radio = itemview.findViewById<RadioButton>(R.id.radioButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.operator_list, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.image.setImageResource(dataList[position].image)
        holder.layout.setBackgroundColor(dataList[position].background)
        if ((mSelectedItem == -1 && position == 0))
            holder.radio.setChecked(true)
        else
            if (mSelectedItem == position)
                holder.radio.setChecked(true)
            else
                holder.radio.setChecked(false)


        holder.radio.setOnClickListener {
            mSelectedItem = holder.adapterPosition
            notifyDataSetChanged()
        }
        holder.itemView.setOnClickListener {
            if (mOnClickListener != null) {
                mOnClickListener!!.onClick(position, dataList[position])
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, todo: OperatorModel)
    }

}