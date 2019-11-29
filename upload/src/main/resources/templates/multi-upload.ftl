<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload</title>
</head>
<body>
<h1>Spring Boot 文件上传</h1>
<form method="post" action="/multiUpload" enctype="multipart/form-data">
    文件1：<input type="file" name="file" />
    文件2：<input type="file" name="file" />
    文件3：<input type="file" name="file" />
    <input type="submit" value="上传" />
</form>
</body>
</html>