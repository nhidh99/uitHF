using System.Collections;
using UnityEngine;

public class Basket : MonoBehaviour
{
    private Vector2 leftPosition = new Vector2(-4, -4);
    private Vector2 rightPosition = new Vector2(4, -4);
    public AudioSource audio;

    void Start()
    {
        audio = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.LeftArrow))
        {
            transform.position = leftPosition;
            audio.Play();
        }
        else if (Input.GetKeyDown(KeyCode.RightArrow))
        {
            transform.position = rightPosition;
            audio.Play();
        }
    }
}
