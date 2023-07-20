"use client";
import { createContext, useContext } from "react";
import { useState } from "react";
import { v4 as uuid } from "uuid";

export const TaskContest = createContext();

export const useTasks = () => {
    const context = useContext(TaskContest);
    if (!context) {
        throw new Error("useTasks must be used within a TaskProvider");
    }

    return context;
};

export const TaskProvider = ({ children }) => {
    const [tasks, setTasks] = useState([{
        id: 1,
        title: "Task 1 Title",
        description: "Description 1",
    },
    {   id: 2,
        title: "Task 2 Title",
        description: "Description 2",
    },
    {   id: 3,
        title: "Task 3 Title",
        description: "Description 3",
    }]);

    const createTask = (title, description) => {
        setTasks([...tasks, { title, description, id: uuid() }]);
    };

    return (
        <TaskContest.Provider
            value={{
                tasks,
                createTask,
            }}
        >
            {children}
        </TaskContest.Provider>
    );
};
