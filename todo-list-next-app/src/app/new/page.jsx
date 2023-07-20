"use client";
import React, { useEffect, useState } from 'react'
import { useRouter } from 'next/navigation';
import { createTask, updateTask } from '@/api/TodoAPIs';

function Page({params}) {
    const [task, setTask] = useState();

    const newTask = async (title, description) => {
        let message = await createTask(title, description); 
        console.log(message);
    }

    const update = async (id, title, description) => {
        var info = {
            id: id,
            title: title,
            description: description
        }

        let message = await updateTask(info);
        console.log(message);
        window.location.replace(`/`);
    }

    const handleChange = (e) =>
        setTask({
            ...task,
            [e.target.name]: e.target.value
        });

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Task: ", task);
        if (task.id){
            update(task.id, task.title, task.description)
        }else{
            newTask(task.title, task.description);
        }
        window.location.replace(`/`);
    }

    useEffect(() => {
        if(params) {
            setTask({
                id: params.id,
                title: params.title,
                description: params.description,
            });
        }
    }, [params]);

    console.log(params)

    return (
        <form onSubmit={handleSubmit}>
            <input placeholder='Write a title' type="text" name="title" id="taskTitle" onChange={handleChange} value={task?.title} />
            <textarea name="description" id="taskDescription" cols="30" rows="3" onChange={handleChange} value={task?.description} />
            <button>Save</button>
        </form>
    )
}

export default Page