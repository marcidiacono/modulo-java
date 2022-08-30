package com.esolutions.java.api;

import static spark.Spark.*;

import com.google.gson.Gson;

public final class App {
    private App() {
    }

    public static void main(String[] args)  {

        final ITodoService service = new TodoServiceMapImpl();

        get("/todos", (req, res) -> {
            res.type("application/json");
            try {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.SUCCESS, new Gson().toJsonTree(service.getTodos())));
            } catch (TodoException exception) {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.ERROR, exception.getMessage()));
            }
        });

        get("/todos/:id", (req, res) -> {
            res.type("application/json");
            try {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.SUCCESS, new Gson().toJsonTree(service.getTodo(Integer.parseInt(req.params(":id"))))));
            } catch (TodoException exception) {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.ERROR, exception.getMessage()));
            }
        });
        
        post("/todos", (req, res) -> {
            res.type("application/json");
            try {
                Todo todo = new Gson().fromJson(
                req.body(), Todo.class);
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.SUCCESS, new Gson().toJson(service.addTodo(todo))));
            } catch (TodoException exception) {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.ERROR, exception.getMessage()));
            }
        });

        put("/todos/:id", (req, res) -> {
            res.type("application/json");
            try {
                Todo todo = new Gson().fromJson(
                req.body(), Todo.class);
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.SUCCESS, new Gson().toJsonTree(service.updateTodo(Integer.parseInt(req.params(":id")), todo))));
            } catch (TodoException exception) {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.ERROR, exception.getMessage()));
            }
        });

        delete("/todos/:id", (req, res) -> {
            res.type("application/json");
            try {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.SUCCESS, new Gson().toJson(service.deleteTodo(Integer.parseInt(req.params(":id"))))));
            } catch (TodoException exception) {
                return new Gson().toJson(new StandarResponse(
                    StatusResponse.ERROR, exception.getMessage()));
            }
        });

    }
}
