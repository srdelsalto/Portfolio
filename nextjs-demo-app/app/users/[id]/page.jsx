const axios = require("axios").default;

async function getUser(id) {

    try {
        const response = await axios.get("https://reqres.in/api/users/" + id);
        const user = response.data;

        console.log(user)
        return user.data;
    } catch (error) {
        return error;
    }
}

async function UsersPage({ params }) {
    const user = await getUser(params.id)
    return (
        <div className="row">
            <div className="col-md-6 offset-md-3">
                <div className="card">
                    <div className="card-header text-center">
                        <img src={user.avatar} alt="" />
                    </div>
                    <div className="card-body text-center">
                        <h3>{user.id} {user.first_name} {user.last_name}</h3>
                        <p>{user.email}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default UsersPage