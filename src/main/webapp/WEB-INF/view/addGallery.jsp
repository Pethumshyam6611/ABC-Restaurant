<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Gallery Image</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Add New Gallery Image</h2>
        <form action="gallery?action=add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="image">Select Image</label>
                <input type="file" class="form-control-file" id="image" name="image" required>
            </div>
            <button type="submit" class="btn btn-primary">Upload Image</button>
            <a href="gallery?action=list" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
