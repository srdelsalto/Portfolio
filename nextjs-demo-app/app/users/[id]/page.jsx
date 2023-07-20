import { getPlaiceholder } from "plaiceholder";
import Image from "next/image";

const axios = require("axios").default;

async function getUser(id) {
    try {
        const response = await axios.get("https://reqres.in/api/users/" + id);
        const user = response.data;

        return user.data;
    } catch (error) {
        return error;
    }
}

async function generateCompleteUserData(id) {
    try {
        const response = await axios.get("https://reqres.in/api/users/" + id);
        const user = response.data;

        const base64 = await getBase64(user.data.avatar)

        const values = {
            user: user.data,
            base: base64
        }

        return values;
    } catch (error) {
        return error;
    }
}

async function getBase64(url) {
    try {
        let value = undefined;
        await getPlaiceholder(url).then((element) => {
            value = element.base64;
        })
        return value;
    } catch (err) {
        console.log('ERROR', err);
    }
}

async function UsersPage({ params }) {
    const user = await getUser(params.id)
    const data = await generateCompleteUserData(params.id)

    console.log("Data", data)
    console.log("user", user)

    return (
        <div className="row">
            <div className="col-md-6 offset-md-3">
                <div className="card">
                    <div className="card-header text-center">
                        <Image
                            src={user.avatar}
                            alt="User Avatar"
                            width={128}
                            height={128}
                            placeholder="blur"
                            blurDataURL={data.base}
                        />
                    </div>
                    <div className="card-body text-center">
                        <h2>User Id: {user.id}</h2>
                        <h3>{user.first_name} {user.last_name}</h3>
                        <p>{user.email}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default UsersPage