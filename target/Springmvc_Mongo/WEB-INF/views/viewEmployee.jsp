<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gradient-to-br from-gray-100 to-gray-200 min-h-screen flex items-center justify-center p-6">

    <div class="bg-white max-w-3xl w-full rounded-xl shadow-lg overflow-hidden">

        <!-- Header -->
        <div class="bg-blue-600 text-white p-6">
            <h2 class="text-2xl font-semibold">Employee Profile</h2>
            <p class="text-sm opacity-90">Detailed employee information</p>
        </div>

        <!-- Details -->
        <div class="p-6">
            <div class="grid grid-cols-2 gap-y-4 gap-x-8 text-sm">

                <div>
                    <p class="text-gray-500">Name</p>
                    <p class="font-medium text-gray-800">${employee.name}</p>
                </div>

                <div>
                    <p class="text-gray-500">Job Title</p>
                    <p class="font-medium text-gray-800">${employee.jobTitle}</p>
                </div>

                <div>
                    <p class="text-gray-500">Department</p>
                    <p class="font-medium text-gray-800">${employee.department}</p>
                </div>

                <div>
                    <p class="text-gray-500">Role</p>
                    <p class="font-medium text-gray-800">${employee.role}</p>
                </div>

                <div>
                    <p class="text-gray-500">Salary</p>
                    <p class="font-medium text-gray-800">
                        ₹ ${employee.salary}
                    </p>
                </div>

                <div>
                    <p class="text-gray-500">Gender</p>
                    <p class="font-medium text-gray-800">${employee.gender}</p>
                </div>

                <div>
                    <p class="text-gray-500">Email</p>
                    <p class="font-medium text-blue-600">${employee.email}</p>
                </div>

                <div>
                    <p class="text-gray-500">Mobile No</p>
                    <p class="font-medium text-gray-800">${employee.mobileNo}</p>
                </div>

                <div class="col-span-2">
                    <p class="text-gray-500">Address</p>
                    <p class="font-medium text-gray-800">
                        ${employee.address}
                    </p>
                </div>

            </div>

            <!-- Actions -->
            <div class="mt-8 flex justify-between">
                <a href="${pageContext.request.contextPath}/editEmployee/${employee.id}"
                   class="bg-yellow-500 text-white px-5 py-2 rounded hover:bg-yellow-600 transition">
                    Edit Employee
                </a>

                <a href="${pageContext.request.contextPath}/dashboard"
                   class="bg-gray-600 text-white px-5 py-2 rounded hover:bg-gray-700 transition">
                    Back to List
                </a>
            </div>
        </div>
    </div>

</body>
</html>
