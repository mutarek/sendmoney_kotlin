import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sendmoney.R
import com.example.sendmoney.newRegistration.kyc.models.ShebaPackageModel

class ShebaPackageAdapter(private val dataList: ArrayList<ShebaPackageModel>) :
    RecyclerView.Adapter<ShebaPackageAdapter.CustomViewHolder>() {

    private var mOnClickListener: OnClickListener? = null
    private var mSelectedItem = -1


    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val pName = itemview.findViewById<TextView>(R.id.packageName)
        val pBankCharge = itemview.findViewById<TextView>(R.id.packageBankChargeTV)
        val pMonthlyLimit = itemview.findViewById<TextView>(R.id.packageMonthlyChargeTV)
        val pCashCharge = itemview.findViewById<TextView>(R.id.packageMonthlyChargeTV)
        val radio = itemview.findViewById<RadioButton>(R.id.packageRadio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sheba_package_layout, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.pName.text = dataList[position].packageName
        holder.pBankCharge.text = dataList[position].bankCharge
        holder.pMonthlyLimit.text = dataList[position].monthlyLimit
        holder.pCashCharge.text = dataList[position].cashoutCharge
        if ((mSelectedItem == -1 && position == 0))
            holder.radio.isChecked = true
        else
            if (mSelectedItem == position)
                holder.radio.isChecked = true
            else
                holder.radio.isChecked = false


        holder.radio.setOnClickListener {
            mSelectedItem = holder.adapterPosition
            if (mOnClickListener != null) {
                mOnClickListener!!.onClick(position, dataList[position])
            }
            notifyDataSetChanged()
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, todo: ShebaPackageModel)
    }

}