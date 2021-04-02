package com.nabin.merotodolist.viewmodel;
/*
 * Nabin Atreya Sunar
 * 77202333
 * The British College
 */
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nabin.merotodolist.data.TodoRepository;
import com.nabin.merotodolist.model.ETodo;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository mTodoRepository;
    private LiveData<List<ETodo>> mAllTodos;

    public TodoViewModel(@NonNull Application application) {
        super(application);

        mTodoRepository = new TodoRepository(application);
        mAllTodos=mTodoRepository.getmAllTodoList();
    }
    public void insert(ETodo todo){
        mTodoRepository.insert(todo);
    }
    public void update(ETodo todo){
        mTodoRepository.update(todo);
    }
    public LiveData<List<ETodo>> getAllTodos() {
        return mAllTodos;
    }
    public ETodo getTodoById(int id){
        return mTodoRepository.getTodoById(id);
    }

    public void deleteById(ETodo todo){
        mTodoRepository.deleteById(todo);
    }
    public void deleteAll(){
        mTodoRepository.deleteAll();
    }
    public void deleteCompleted(){
        mTodoRepository.deleteCompleted();
    }
}
