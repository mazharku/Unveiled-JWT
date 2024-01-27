from jose import jwt


class JWTUtil:

    def __init__(self, secret: str):
        self.secret = secret

    def validate_token(self, token: str):
        try:
            jwt.decode(
                token=token, key=self.secret, algorithms=["HS512"]
            )
            print("token validate successfully!")
        except jwt.ExpiredSignatureError:
            print("Token has expired")
        except Exception as e:
            print(str(e))
