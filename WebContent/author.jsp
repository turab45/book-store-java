<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap Elegant Table Design</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<script src="//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>



<style>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Roboto', sans-serif;
}

.table-responsive {
	margin: 30px 0;
}
</style>
</head>
<body>

	<div class="container">

		<div class="jumbotron text-center" style="height:10px; background-color: transparent;">
			<h1>Author's</h1>
			<!-- Button trigger modal -->
		<button style="width:100px" type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal">Add</button>
		</div>
		<!-- Modal -->

		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add New Author</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<form>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">Author
									Name</label> <input type="text" class="form-control"
									id="author-name">
							</div>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label"
									data-toggle="tooltip" data-placement="top"
									title="No of publications">Publications</label> <input
									type="number" class="form-control" id="publications">
							</div>

						</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" id="addBtn" class="btn btn-primary">Save</button>
					</div>
				</div>
			</div>
		</div>

		<table id="authorTable">
			<thead>
				<tr>

					<th>Name</th>
					<th>No of Publications</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>

			</thead>
			<tbody>
			</tbody>
		</table>

	</div>


	<script>
		$(document).ready(function() {

			$('#authorTable').DataTable();

			$("#addBtn").on('click', function() {

				var authorName = $('#author-name').val();
				var publications = $('#publications').val();

				console.log(authorName);
				console.log(publications)
				
				var data = {
					"name":authorName,
					"publication":publications
					}

				$.ajax({
				    type: 'POST',
				    url:'AuthorServlet?action=create&&name='+authorName+'&&publication='+publications,
				    contentType: "application/json"
				});

			});
		});
	</script>
</body>
</html>


