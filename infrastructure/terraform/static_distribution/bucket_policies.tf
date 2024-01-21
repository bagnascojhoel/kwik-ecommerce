data "aws_iam_policy_document" "bucket_policy_for_cloudfront_private_content" {
  policy_id = "BucketPolicyForCloudFrontPrivateContent"

  statement {
    sid = "AllowCloudFrontReadAccess"
    effect = "Allow"
    actions = [ "s3:GetObject" ]
    resources = [ "${aws_s3_bucket.distribution_source.arn}/*" ]
    
    principals {
      type = "Service"
      identifiers = ["cloudfront.amazonaws.com"]
    }

    condition {
      test = "StringEquals"
      variable = "AWS:SourceArn"
      values = [ aws_cloudfront_distribution.static_distribution.arn ]
    }
  }
}