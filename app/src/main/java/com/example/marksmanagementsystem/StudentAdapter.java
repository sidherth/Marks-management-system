package com.example.marksmanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Viewholder> {

    List<Student>studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_design,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.Viewholder holder, int position) {

        Student student = studentList.get(position);

        holder.studentIdTV.setText(student.getStudentID());
        holder.subjectTV.setText(student.getSubject());
        holder.marksTV.setText(student.getMarks());
        holder.departmentTV.setText(student.getDepartment());
        holder.genderTV.setText(student.getGender());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView studentIdTV,subjectTV,marksTV,departmentTV,genderTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            studentIdTV = itemView.findViewById(R.id.studentIdTV);
            subjectTV = itemView.findViewById(R.id.subjectTV);
            marksTV = itemView.findViewById(R.id.marksTV);
            departmentTV = itemView.findViewById(R.id.departmentTV);
            genderTV = itemView.findViewById(R.id.genderTV);
        }
    }
}
