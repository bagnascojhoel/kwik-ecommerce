variable "distribution_source_id" {
  type = string
}

variable "distribution_domain" {
  type = string
}

variable "acm_certificate_arn" {
  type = string
}

resource "aws_cloudfront_origin_access_control" "kwik_default" {
  name = var.distribution_source_id
  origin_access_control_origin_type = "s3"
  signing_behavior = "always"
  signing_protocol = "sigv4"
}

resource "aws_cloudfront_cache_policy" "kwik_default" {
  name = var.distribution_source_id
  min_ttl = 0
  default_ttl = 86400

  parameters_in_cache_key_and_forwarded_to_origin {
    cookies_config {
      cookie_behavior = "none"
    }

    headers_config {
      header_behavior = "none"
    }

    query_strings_config {
      query_string_behavior = "none"
    }
  }
}

resource "aws_cloudfront_distribution" "static_distribution" {
  depends_on = [ aws_s3_bucket.distribution_source ]

  origin {
    domain_name = aws_s3_bucket.distribution_source.bucket_regional_domain_name
    origin_access_control_id = aws_cloudfront_origin_access_control.kwik_default.id
    origin_id   = var.distribution_source_id
  }

  enabled             = true
  default_root_object = "index.html"

  aliases  = [var.distribution_domain]

  default_cache_behavior {
    cache_policy_id = aws_cloudfront_cache_policy.kwik_default.id
    target_origin_id = var.distribution_source_id

    allowed_methods  = ["GET", "HEAD"]
    cached_methods   = ["GET", "HEAD"]

    default_ttl = 86400
    viewer_protocol_policy = "redirect-to-https"
  }

  price_class = "PriceClass_100"

  restrictions {
    geo_restriction {
      restriction_type = "none"
    }
  }

  tags = {
    System = "kwik"
    ApplicationName = var.app_name
  }

  viewer_certificate {
    acm_certificate_arn = var.acm_certificate_arn
    ssl_support_method = "sni-only"
  }
}

output "cloudfront_domain" {
  value = aws_cloudfront_distribution.static_distribution.domain_name
}