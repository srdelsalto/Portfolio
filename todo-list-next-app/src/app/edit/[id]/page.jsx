"use client";
import { getTask } from '@/api/TodoAPIs';
import React, { useState, useEffect } from 'react'
import NewFormPage from '@/app/new/page'

function Page({ params }) {
    const [task, setTask] = useState({});

    const fetchTask = async (id) => {
        let fetchedTask = await getTask(id);
        setTask(fetchedTask);
    };

    useEffect(() => {
        let searchedId = params.id;

        fetchTask(searchedId);
    }, [params]);

    return (
        <>
            <div>Editando {params.id} <br /></div>
            <div>
                <h1>{task.title}</h1>
                <p>{task.description}</p>
            </div>
            <NewFormPage params = {task} />
        </>
    )
}

export default Page