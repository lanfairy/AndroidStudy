package com.example.baselayoutdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<CellData> data;

    public ArrayList<CellData> getData() {
        if (data == null){
            data = new ArrayList<CellData>();
            for (int i = 0; i < 50; i++) {
                data.add(new CellData("阿弥陀佛"+i, "果然又是骗人的"+i));
            }
        }
        return data;
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position, String testStr);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public void addData(int position) {
        data.add(position, new CellData("新插入的值"+position, "content 新值哟"));
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder vh = (ViewHolder) holder;
        CellData cellData = getData().get(position);
        vh.getTvTitle().setText(cellData.title);
        vh.getTvContent().setText(cellData.content);
        //如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = vh.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(vh.itemView, pos, data.get(pos).title);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View root;
        private TextView tvTitle, tvContent;

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContent() {
            return tvContent;
        }

        public View getRoot() {
            return root;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            root = itemView;

            tvTitle = root.findViewById(R.id.tvTitle);
            tvContent = root.findViewById(R.id.tvContent);
        }
    }

//    private CellData[] data = new CellData[]{
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的"),
//            new CellData("阿弥陀佛", "果然又是骗人的")
//    };
}
