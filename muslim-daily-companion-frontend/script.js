const API_BASE_URL = "http://localhost:8080/api";

function authHeaders() {
    const token = localStorage.getItem("token");
    return {
        "Content-Type": "application/json",
        "Authorization": "Bearer " + token
    };
}

async function registerUser() {
    const fullName = document.getElementById("fullName").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const message = document.getElementById("message");

    message.textContent = "";
    message.className = "";

    if (!fullName || !email || !password) {
        message.textContent = "Please fill in all fields.";
        message.className = "error";
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/users`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ fullName, email, password })
        });

        if (!response.ok) {
            throw new Error("Registration failed. Email may already be in use.");
        }

        message.textContent = "Registration successful! Redirecting to login...";
        message.className = "success";

        setTimeout(() => {
            window.location.href = "login.html";
        }, 1500);

    } catch (error) {
        message.textContent = error.message;
        message.className = "error";
    }
}

async function loginUser() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const message = document.getElementById("message");

    message.textContent = "";
    message.className = "";

    if (!email || !password) {
        message.textContent = "Please fill in all fields.";
        message.className = "error";
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/users/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        if (!response.ok) {
            throw new Error("Invalid email or password.");
        }

        const token = await response.text();

        localStorage.setItem("token", token);
        localStorage.setItem("email", email);

        message.textContent = "Login successful! Redirecting...";
        message.className = "success";

        setTimeout(() => {
            window.location.href = "dashboard.html";
        }, 1000);

    } catch (error) {
        message.textContent = error.message;
        message.className = "error";
    }
}