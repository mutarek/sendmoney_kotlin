import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.model.BulkTopupModel
import com.example.sendmoney.model.OfferModel
import com.example.sendmoney.model.OperatorModel

class BulkTopupDetailsAdapter(private val dataList: ArrayList<BulkTopupModel>) :
    RecyclerView.Adapter<BulkTopupDetailsAdapter.CustomViewHolder>() {
    private var mOnClickListener: OnClickListener? = null

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val ammount = itemview.findViewById<TextView>(R.id.contactAmmountTV)
        val number = itemview.findViewById<TextView>(R.id.contactNumberTV)
        val delete = itemview.findViewById<ImageView>(R.id.deleteContact)
        val operator = itemview.findViewById<ImageView>(R.id.contactOperatorIMG)
        val type = itemview.findViewById<TextView>(R.id.rechargeType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.bulk_top_up_details_layout, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        if (dataList.isEmpty()) {

        } else
            holder.ammount.text = dataList[position].amount
        holder.number.text = dataList[position].number
        holder.type.text = dataList[position].type

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, todo: BulkTopupModel)
    }

}