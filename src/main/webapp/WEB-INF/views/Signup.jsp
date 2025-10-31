<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f8f9fa;
        }
        .signup-card {
            max-width: 500px;
            margin: 60px auto;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            background-color: #fff;
        }
        .form-title {
            text-align: center;
            margin-bottom: 25px;
        }
        .btn-primary {
            width: 100%;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="signup-card">
        <h3 class="form-title">Create Account</h3>
        <form action="signup" method="post" enctype="multipart/form-data">
            
            <!-- First Name -->
            <div class="mb-3">
                <label class="form-label">First Name</label>
                <input type="text" name="firstName" class="form-control" placeholder="Enter first name" required>
            </div>

            <!-- Last Name -->
            <div class="mb-3">
                <label class="form-label">Last Name</label>
                <input type="text" name="lastName" class="form-control" placeholder="Enter last name" required>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label class="form-label">Email address</label>
                <input type="email" name="email" class="form-control" placeholder="Enter email" required>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter password" required>
            </div>


             <div class="mb-3">
                <label class="form-label">Profile Pic</label>
                <input type="file" name="profilePic" class="form-control"   required>
            </div>


            <!-- Gender -->
            <div class="mb-3">
                <label class="form-label">Gender</label>
                <select name="gender" class="form-select" required>
                    <option value="" selected disabled>Select gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <!-- Submit -->
            <button type="submit" class="btn btn-primary">Sign Up</button>

            <div class="text-center mt-3">
                <small>Already have an account? <a href="login">Login here</a></small>
            </div>

        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
