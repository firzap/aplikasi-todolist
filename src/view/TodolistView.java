package view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist(){
        while (true){
            todolistService.showTodolist();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var pilih = InputUtil.input("Pilih menu");
            if (pilih.equals("1")){
                addTodolist();
            } else if (pilih.equals("2")){
                removeTodolist();
            } else if (pilih.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dikenali...");
            }
        }
    }

    public void addTodolist(){
        System.out.println("Tambah TO DO LIST");

        var todo = InputUtil.input("TO DO (x untuk membatalkan)");

        if (todo.equals("x")){
            //batal
        } else {
            todolistService.addTodolist(todo);
        }
    }

    public void removeTodolist(){
        System.out.println("Menghapus TO DO LIST");

        var number = InputUtil.input("Nomor Todo List yang dihapus (x untuk membatalkan)");

        if (number.equals("x")){
            //batal
        } else {
            todolistService.removeTodolist(Integer.valueOf(number));
        }
    }
}
