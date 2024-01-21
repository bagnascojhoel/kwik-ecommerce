provider "aws" {
  region = "us-east-1"
}

locals {
  ssl_validate = true
  domain = "bagnascojhoel.com.br"
  kwik_bucket_prefix = "kwik"
  static_distributions = toset(["kwik-management", "kwik-chat"])
}

resource "aws_acm_certificate" "kwik_certificate" {
  domain_name = local.domain
  subject_alternative_names = [format("*.%s", local.domain)]
  validation_method = "DNS"

  lifecycle {
    create_before_destroy = true
  }
}

output "kwik_domain_valid_options" {
  value = toset([
    for dvo in aws_acm_certificate.kwik_certificate.domain_validation_options : {
      domain = dvo.domain_name
      name = dvo.resource_record_name
      type = dvo.resource_record_type
      value = dvo.resource_record_value
    }
  ])
}

resource "aws_acm_certificate_validation" "kwik_certificate_validation" {
  count = local.ssl_validate ? 1 : 0
  certificate_arn = aws_acm_certificate.kwik_certificate.arn
}

module "kwik_static_distribution" {
  depends_on = [ aws_acm_certificate.kwik_certificate ]
  source = "./static_distribution"

  for_each = local.static_distributions

  acm_certificate_arn = aws_acm_certificate.kwik_certificate.arn
  distribution_domain = format("%s.%s", each.key, local.domain)
  distribution_source_id = format("%s-%s", local.kwik_bucket_prefix, each.key)
  app_name = each.key
}

output "static_distributions" {
  depends_on = [ module.kwik_static_distribution ]
   value = module.kwik_static_distribution.*
}