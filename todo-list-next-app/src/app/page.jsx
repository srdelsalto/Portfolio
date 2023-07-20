"use client";
import TaskCard from '@/components/TaskCard';
import { useTasks } from '@/context/TasksContext'
import { useEffect, useState } from 'react';
import { deleteTask, getTasks } from '@/api/TodoAPIs';

function Page() {
  const [tasks, setTasks] = useState([]);

  const loadTasks = async () => {
    let fetchedTasks = await getTasks();
    setTasks(fetchedTasks);
  };

  useEffect(() => {
    loadTasks();
  }, []);

  return (
    <>
      <div>
        <h1 style={{ paddingBottom: 30 }}>Home Page</h1>
      </div>
      <div>
        {tasks.map((task) => (
          !task.status ? <TaskCard key={task.id} task={task} styleObj={{background: "#202020", text: "white"}} props={{loadTasks}} /> : <TaskCard key={task.id} task={task} styleObj={{background: "green", text: "white"}}/>
        ))}
      </div>
    </>
  )
}

export default Page