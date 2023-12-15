type JsonFetchParams = {
  url: string
  body: object
  timeout?: number
}

async function post({ url, body, timeout = 20000 }: JsonFetchParams): Promise<Response> {
  const abortController = new AbortController();
  const timeoutAbortId = setTimeout(
    () => abortController.abort(new DOMException('request timed out')),
    timeout);
  const response: Response = await fetch(
      url, {
      method: 'POST',
      body: JSON.stringify(body),
      headers: {
        'content-type': 'application/json'
      },
        credentials: 'include',
      signal: abortController.signal
    }
  );
  clearTimeout(timeoutAbortId);
  return response;
}

export type { JsonFetchParams };
export { post }