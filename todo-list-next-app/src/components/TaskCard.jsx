import { useRouter } from 'next/navigation'
import React from 'react'
import { deleteTask } from '@/api/TodoAPIs';

function TaskCard({ task, styleObj, props }) {
    const router = useRouter();

    const deleteTaskPetition = async (id) => {
        let message = await deleteTask(id);
        console.log(message);
        props.loadTasks();
    };

    return (
        <div style={{ background: styleObj.background, color: styleObj.text }} onClick={() => { router.push(`/edit/${task.id}`) }}>
            <h1>
                {task.title}
            </h1>
            <button onClick={(e) => {
                e.stopPropagation();
                deleteTaskPetition(task.id)
            }}>
                Delete
            </button>
            <p>
                {task.description}
            </p>
        </div>
    )
}

export default TaskCard