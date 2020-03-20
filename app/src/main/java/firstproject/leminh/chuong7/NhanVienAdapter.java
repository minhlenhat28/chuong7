package firstproject.leminh.chuong7;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NhanVienAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private int visiblethrhold = 5;
    private int totalitemcount;
    private int lastvisibleitem;
    public boolean isLoading = false;
    OnLoadMoreListener onLoadMoreListener;
    RecyclerView recyclerView;
    MainActivity context;
    ArrayList<NhanVien> nhanviens;
    public OnLoadMoreListener getonLoadMoreListener(){
        return onLoadMoreListener;
    }
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener){
        this.onLoadMoreListener = onLoadMoreListener;
    }
    public void setLoading(boolean loading) {
        isLoading = loading;
    }
    public void setLoaded(){ //sau khi load xong => tra ve false
        isLoading = false;
    }

    public NhanVienAdapter(RecyclerView recyclerView, MainActivity context, ArrayList<NhanVien> nhanViens){
        this.recyclerView = recyclerView;
        this.context = context;
        this.nhanviens = nhanViens;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                        totalitemcount = linearLayoutManager.getItemCount();//gia tri cua mang
                        lastvisibleitem = linearLayoutManager.findLastCompletelyVisibleItemPosition();//gia tri nhin thay cuoi cung
                    if(!isLoading && totalitemcount <= lastvisibleitem+visiblethrhold){
                        if (onLoadMoreListener != null){
                            onLoadMoreListener.OnLoadMore();
                        }
                        isLoading = true;
                    }
                }
            });
        }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate, lay view
        if (viewType == VIEW_TYPE_ITEM){
            View nhanvienview = LayoutInflater.from(context).inflate(R.layout.nhanvien,parent,false);
            return new NhanVIenViewHolder(nhanvienview);
        }else if (viewType == VIEW_TYPE_LOADING){
            View loadingview = LayoutInflater.from(context).inflate(R.layout.loadingitem,parent,false);
            return new LoadingViewHolder(loadingview);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {//set gia tri
        if(holder instanceof NhanVIenViewHolder){
            NhanVien nhanVien = nhanviens.get(position);
            NhanVIenViewHolder nhanVIenViewHolder = (NhanVIenViewHolder) holder;

            nhanVIenViewHolder.tennv.setText(nhanVien.getTennv());
            nhanVIenViewHolder.manv.setText(nhanVien.getManv());
            nhanVIenViewHolder.gender.setImageResource(nhanVien.getGender());

        }else if (holder instanceof LoadingViewHolder){
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return nhanviens == null? 0:nhanviens.size();
    }

    @Override
    public int getItemViewType(int position) {
        return nhanviens.get(position) == null? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }
}
