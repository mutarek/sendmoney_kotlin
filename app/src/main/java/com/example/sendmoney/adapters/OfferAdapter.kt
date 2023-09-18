import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.OfferModel
import com.example.sendmoney.model.OperatorModel

class OfferAdapter(private val dataList: ArrayList<OfferModel>) :
    RecyclerView.Adapter<OfferAdapter.CustomViewHolder>() {

    private var mOnClickListener: OnClickListener? = null
    private var mSelectedItem = -1


    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val ammount = itemview.findViewById<TextView>(R.id.offerAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.offer_layout, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.ammount.text = dataList[position].amount
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, todo: OperatorModel)
    }

}