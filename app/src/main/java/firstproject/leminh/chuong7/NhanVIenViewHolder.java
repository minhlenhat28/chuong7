package firstproject.leminh.chuong7;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class NhanVIenViewHolder extends RecyclerView.ViewHolder {
    ImageView gender;
    TextView manv;
    TextView tennv;
    public NhanVIenViewHolder(@NonNull View itemView) {
        super(itemView);
        gender = (ImageView) itemView.findViewById(R.id.gender);
        manv = (TextView) itemView.findViewById(R.id.tvmanv);
        tennv = (TextView) itemView.findViewById(R.id.tvtennv);
    }
}
