const URL = "http://localhost:8080/tasks"

export const getTasks = async () => {
    const response = await fetch(URL);
    const data = await response.json();

    return data;
};

export const getTask = async (id) => {
    const response = await fetch(URL + "/" + id);
    const data = await response.json();

    return data;
};

export const updateTaskState = async (id) => {
    const response = await fetch(URL + "/status/" + id, {
        method: "PUT",
    });
    const data = await response.json();

    console.log(data);

    return data;
};

export const updateTask = async (updateInfo) => {
    var data = {
        id: updateInfo.id,
        title: updateInfo.title,
        description: updateInfo.description,
    }
    
    const response = await fetch(URL, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json",
        },
    });
    
    const message = await response.json();

    console.log(message);

    return message;
};

export const createTask = async (title, description) => {
    var data = {
        title: title,
        description: description,
    }
    
    const response = await fetch(URL, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json",
        },
    });
    
    const message = await response.json();

    console.log(message);

    return message;
};

export const deleteTask = async (id) => {
    var data = {
        id: id,
    }

    const response = await fetch(URL, {
        method: "DELETE",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json",
        },
    });

    const message = await response.json();

    console.log(message);

    return message;
};