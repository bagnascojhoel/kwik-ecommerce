resource "aws_s3_bucket" "distribution_source" {
  bucket = var.distribution_source_id
  force_destroy = false

  tags = {
    System = "kwik"
    ApplicationName = var.app_name
  }
}

resource "aws_s3_bucket_policy" "distribuition_source_bucket_policy" {
  depends_on = [ aws_cloudfront_distribution.static_distribution ]
  bucket = aws_s3_bucket.distribution_source.id
  policy = data.aws_iam_policy_document.bucket_policy_for_cloudfront_private_content.json
}

output "bucket_name" {
  value = aws_s3_bucket.distribution_source.id
}