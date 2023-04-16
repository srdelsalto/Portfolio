import Users from "@/components/users";
import React from "react";

const axios = require("axios").default;

async function getUsers() {
  let users = [];

  try {
    const response = await axios.get("https://reqres.in/api/users");
    const totalUsers = response.data.total;

    const finalResponse = await axios.get(
      "https://reqres.in/api/users?per_page=" + totalUsers
    );
    const finalData = finalResponse.data;

    return finalData.data;
  } catch (error) {
    return error;
  }
}

async function IndexPage() {
  const users = await getUsers();
  return (
    <div>
      <Users users={users}/>
    </div>
  );
}

export default IndexPage;
